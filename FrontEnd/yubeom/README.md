## <b>2023-01-17 </b>

# 안드로이드-네트워킹

## Retrofit2

- 앱에서 네트워킹 하기 위해서 manifest 파일에
  <uses-permission android:name=”android.permission.INTERNET”/>

  작성

- http 통신은 금지되어서 https를 사용
- http 통신을 하고싶다면 사용하기 위한 설정
  - res/xml 폴더에 임의의 이름으로 xml 파일 생성 후 아래 코드 작성
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <network-security-config>
    	<domain-config CleartextTrafficPermitted="true">
    		<domain includeSubdomains="true"> 도메인 명 </domain>
    		<domain includeSubdomains="true"> 도메인 명 </domain>
    			...
    	</domain-config>
    </network-security-config>
    ```
- interface( -add() , -get() , ) =⇒ Retrofit =⇒ Service( -add(){} , -get(){},.. ) =⇒ call객체
- build.gradle 파일에 의존성 주입 필요
  - server에서 정보를 json이나 xml 파일로 주면 파싱 필요 →
    파싱 ( model 생성, data setting ) → converter가 자동으로 해줌
  - converter를 사용하기 위해서는 json,xml 파서가 필요
    - 외부 라이브러리 이용 ( Gson , … )
  - implementation retrofit2, gson, converter
- Model 정의 ( dto )

  - 백에서 넘겨오는 데이터에 맞춰 dto 구성
  - 서버의 데이터 키값과 변수명이 다를 경우 dto 생성할 때 serializedName 어노테이션 붙여주기

    ```xml
    @SerializedName(”publishedAt”)

    public String published_at;
    ```

- Retorfit 객체 생성 ( 한번만 실행하면 됨, 주로 응용프로그램이 최초 실행할 때 한번만 실행하게 함 )
  ```java
  public class RetrofitHelper {
  	static Retrofit getRetrofit(){
  		return new Retrofit.Builder().
  					.baseUrl("https:// ~~ ") // 파라미터 붙는거 제외 기본 url
  					.addConverterFactory(GsonConverterFactory.create())
  					.build();
  	}
  }
  ```
- Retrofit의 핵심은 서버 네트워킹을 위한 함수를 인터페이스의 추상 함수로 만들고 그 함수에 어노테이션으로 GET/POST 등의 HTTP method와 서버 전송 질의를 지정하면 , 그 정보에 맞게 서버를 연동하는 Call 객체를 자동으로 만들어 주는 구조
- Service 인터페이스

  ```java
  public interface RetrofitService{

  @GET("/v2/everything")
  Call<PageListModel> getList(@Query("q") String q,
  														@Query("apiKey") String apiKey,
  														@Query("page") long page,
  														@Query("pageSize") int pageSize);
  }
  ```

- Call 객체 획득
  ```java
  networkService = RetrofitHelper.getRetrofit().create(RetrofitService.class);
  ```
  Retrofit 객체의 create() 함수로 네트워킹을 위한 Call 객체를 가지는 Service 객체가 자동으로 만들어지고 , service객체를 이용하여 인터페이스에서 정의한 함수를 호출하면 Call 객체가 반환된다.
  ```java
  Call<PageListModel> call = networkService.getList(QUERY,API_KEY,1,2)
  ```
- 네트워킹 시도 (enqueue() )

  ```java
  Call.enqueue(new Callback<PageListModel>(){
  	@Override
  	public void onResponse(Call<PageListModel> call, Response<PageListModel> response){
  			if(response.isSuccessful()){
  				....
  				....
  	}
  @Override
  	public void onFailuer(Call<PageListModel> call, Throwable t ){

  	}
  }
  ```

- Retrofit2 어노테이션
  - @GET,@POST,@PUT,@DELETE,@HEAD
  - @Path : URL의 Path 부분 동적 할당
    - @GET(”group/{id}/users”
      - Call<List<UserModel>> groupList(@Path(”id) int gruopId, ,… ) ;
  - @Body : 객체를 request body 에 포함 ( POST 방식에서 사용 )
- Glide 라이브러리
