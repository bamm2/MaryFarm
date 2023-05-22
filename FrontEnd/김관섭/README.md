## 2021-01-16

---

- 대전 B308 김관섭
- 2023.01.16 (월)
- 안드로이드 실습 (자바)
- 안드로이드 이론 공부 (자바)

---

- View의 기초 속성 & 활용

---
XML 코드

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="16dp"
    android:orientation="horizontal">

    <ImageView
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:src="@drawable/icon"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:layout_weight="1">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="김관섭"
            android:textSize="20dp"
            android:textStyle="bold"
            android:layout_marginLeft="16dp"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="안녕하세요. 잘 지내시는 지요"
            android:layout_marginTop="16dp"
            android:layout_marginLeft="16dp"/>
    </LinearLayout>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="1월 15일"
        android:layout_marginLeft="16dp"/>

</LinearLayout>

---