# Kakao Dev 설정 (Oauth/인가코드수신)

1. Kakao Developers 로그인

[Kakao Developers](https://developers.kakao.com/)

1. 내 애플리케이션 등록

![Untitled](Kakao%20Dev%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%20(Oauth%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%E1%86%AB)%20c46ee5b50c464f608b5f04576a2275d5/Untitled.png)

1. 앱 키의 네이티브 앱 키를 어플 내부에서 KAKAO API KEY로 사용

![Untitled](Kakao%20Dev%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%20(Oauth%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%E1%86%AB)%20c46ee5b50c464f608b5f04576a2275d5/Untitled%201.png)

1. 컴퓨터의 키를 얻어서 내 어플리케이션 > 앱 설정 > 플랫폼 > 수정 > 키 해시에 등록

![Untitled](Kakao%20Dev%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%20(Oauth%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%E1%86%AB)%20c46ee5b50c464f608b5f04576a2275d5/Untitled%202.png)

1. 키 해시 얻는 방법
- 1. Open SSL 다운 후, 터미널에서 추출하기
    
    [OpenSSL](https://sourceforge.net/projects/openssl/)
    
- 2.어플 내부에서 코드로 추출하기
    
    KakaoLogin/KakaoLoginActivity.java 파일의 
    onCreate 메서드 아래에 다음의 코드를 추가하여 실행하면
    onCreate 할때 Log.d("KeyHash", getKeyHash()); 과 같이 키해시 값 얻을 수있다.
    콘솔에서 출력된  해시값을 복사해서 카카오 디벨로퍼에 저장
    
    ![Untitled](Kakao%20Dev%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%20(Oauth%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%E1%86%AB)%20c46ee5b50c464f608b5f04576a2275d5/Untitled%203.png)
    
    ```java
    // 키해시 얻기
      public String getKeyHash(){
          try{
              PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
              if(packageInfo == null) return null;
              for(Signature signature: packageInfo.signatures){
                  try{
                      MessageDigest md = MessageDigest.getInstance("SHA");
                      md.update(signature.toByteArray());
                      return android.util.Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                  }catch (NoSuchAlgorithmException e){
                      Log.w("getKeyHash", "Unable to get MessageDigest. signature="+signature, e);
                  }
              }
          }catch(PackageManager.NameNotFoundException e){
              Log.w("getPackageInfo", "Unable to getPackageInfo");
          }
          return null;
      }
    ```
    
- 3.Google Play Console에서 추출하기
    1. Google Play Console 접속
    2. key hash 추출할 앱 클릭
    3. 출시 → 설정 → 앱 무결성
    4. 앱 서명 → SHA-1 인증서 지문 복사

[Android :: 해시키, 키해시(Key Hash)의 개념과 활용 / 생성방법](https://manorgass.tistory.com/76)

[[Android] 키해시(key hash) 추출하기](https://velog.io/@iamjm29/Android-%ED%82%A4%ED%95%B4%EC%8B%9Ckey-hash-%EC%B6%94%EC%B6%9C%ED%95%98%EA%B8%B0)

더 자세한 내용은 위의 자료 중 이해가 잘 가는 내용으로 참고하세요.

1. 동의 항목의 카카오 로그인 ON
2. 개인정보의 닉네임 프로필 사진 필수동의 설정

![Untitled](Kakao%20Dev%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%20(Oauth%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%80%E1%85%A1%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3%E1%84%89%E1%85%AE%E1%84%89%E1%85%B5%E1%86%AB)%20c46ee5b50c464f608b5f04576a2275d5/Untitled%204.png)