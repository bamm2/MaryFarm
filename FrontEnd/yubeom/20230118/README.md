<b> 2023 - 01 - 18 공부내용 </b>

---

# 안드로이드

## ANR(Activity Not Response) - 5초 rule

- 무선 네트워크 사용 시 데이터 지연으로 시간이 오래 걸릴 확률이 있다.
- 해결방안 : Main Thread 에서 Thread가 빠져나와 병렬적으로 작업
  - 빠져나온 Thread는 Handler를 통해 메인 쓰레드에 의뢰해서 작업
  - 비효율적
- 해결 방안 : Coroutine (Kotlin 언어에서 제공 ) , Rxjava ( java )
- Rxjava
  - build.gradle 에 의존성 설정
  - Observable 만들기
  - Observer : Observable이 발생한 데이터를 획득하기 위한

---

BroadcastReceiver : 이벤트 모델로 실행 ( code로 동적 등록,해제 가능 )

- 예제 ) 화면 On/Off , 배터리상황 ,
- class A extends BroadcastReceiver
- onReceive() 함수 하나만 존재
- xml → <receive >
- Intent로 데이터 넣어서 → sendBrodcast(intent) 넘겨주기

Activity Intent는 인텐트 발생 했는데 없으면 에러

여러 개 발생해도 유저가 선택한 하나만 실행

Receiver Intent는 인텐트 발생 → 없으면 → 아무일도 없음

여러 개 발생하면 모두 실행

---

Service : 장시간 , background 작업

- startService(intent)
  - Intent 하나에 onCreate() 최초 한번 호출
    - startService(intent) 시 onStartCommand() 호출
  - 서비스 종료하기 위한 Intent 생성 후 stopService(intent) 호출,→ onDestory() 호출
- bindService()
  - Intent 생성 후 onBind() : 유일하게 return값 존재 ( IBinder )
  - bindService(intent) ,..bindService(intent) 호출
  - 종료 → unbindService()

AIDL : 안드로이드에서 프로세스 간의 통신 ( bindService() 이용 )

- aidl 파일 작성 ( 확장자가 aidl 파일 하나 작성)
  - 자바의 인터페이스와 동일하게 작성 ( 확장자만 aidl )
- 서비스 작성 ( onBind ) 함수에서 return aidl인터페이스 Stub() 하여
  - aidl 메서드 구현
- bindService() 함수에 의해 서비스 실행 ( 외부 앱과 통신이므로 패키지명 지정 필요)

---

Content provider : 앱 간의 데이터 공유를 목적으로 사용되는 컴포넌트

authorities= “” → 등록 필수 ( 식별자 )

---

카메라

- 카메라 앱 연동 방법 2가지
  썸네일 방식 → 파일 용량이 커 사이즈가 작아짐
  file정보 방식 → 내부 정보를 줘야하므로 보안상의 문제 우려
  - FileProvider

---

## SQLite을 이용한 데이터 영속적 저장

- 로컬 DB / 백엔드와는 네트워킹을 통해 데이터 교환
- SQLite 이용한 데이터는 파일에 저장
  - 경로 : data/data/[package_name]/databases
- SQLiteDatabase 클래스
  - 데이터 저장,수정,삭제 모든 SQL 질의문은 SQLiteDatabase 클래스의 함수를 이용하여 수행
  ```java
  SQLiteDatabase db = openOrCreateDatabase("memodb",MODE_PRIVATE,null);
  ```
  - execSQL(String sql) : insert,update 등 select 문이 아닌 나머지 SQL 수행
  - rawQuery(String sql,String[] selectionArgs,Object[] bindArgs): select SQL 수행
    Cursor 객체
- SQLiteOpenHelper 클래스
  - DBHelper 생성자 → 매개변수 , dbfile, null , db버전
  - onCreate() → 최초 한번 ( 주로 , create table )
  - onUpgrade() → 버전 업데이트 시 ( 주로 ,스키마 변경 )
  ```java
  DBHelper helper=new DBHelper(this);
  SQLiteDatabase db =helper.getWritableDatabase();
  ```

---

## SharedPreferences ( 앱 설정에 주로 사용 )

- 앱의 데이터를 영속적으로 저장할 때 사용하는 클래스
  - Context.getSharedPreferences(String name, int mode)

---

앱 설정 자동화 기법

- build.gradle 에 의존성 주입
  - implementation ‘androidx.preference:preference-ktx:1.1.1’
- res 하위에 xml 폴더 생성 후 xml 파일 작성
  - <PreferenceScreen> 설정 XML 의 root 태그
  - <PreferenceCategory> 설정 여러 개를 시각적으로 묶어서 표현
  - <Preference> 설정 화면 중첩
  - <CheckboxPreference> 체크박스가 나오는 설정
  - <EditTextPreference> 글 입력을 위한 설정
  - <ListPreference> 항목 다이얼로그를 위한 설정
  - <SwitchPreferenceCompat> 스위치를 이용한 설정

---

FCM

App —- (HTTP , (Retrofit2) ) —> 서버 http 요청 보내고 끊어버림

서버에서 넘겨주고 싶을 때 push service (파이어베이스) 를 통해 데이터 전달

---

위치 정보 획득

LocationManager ( 플랫폼 API )

Fused API ( 구글 제공 API ) - 의존성 주입 후 사용
