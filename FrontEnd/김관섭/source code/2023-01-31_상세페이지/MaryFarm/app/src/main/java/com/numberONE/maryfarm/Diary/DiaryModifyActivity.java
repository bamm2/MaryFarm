package com.numberONE.maryfarm.Diary;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.TextView;

import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.ActivityDiaryModifyBinding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// 완료한 부분 : 제목, 이미지, 작물종류, 내용, 저장버튼 있음
//             카메라, 갤러리, 사진 미리보기, 완료 후 페이지 이동 완료
// 추가할 부분 : 서버와 정보 주고받기
public class DiaryModifyActivity extends AppCompatActivity {

    String filePath;
    Bitmap ImgPath;

    ActivityDiaryModifyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiaryModifyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 디테일 페이지에서 데이터 가져오기
        Intent detailintent=getIntent();
        String content=detailintent.getStringExtra("content");

        binding.editTextBox.setText(content);
        // setImageResource()로 이미지 변경
        // 제목, 작물종류 변경

        //카메라 실행 > 결과값 게시
        ActivityResultLauncher<Intent> cameraFileLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        int calRatio = calculateInSampleSize(
                                Uri.fromFile(new File((filePath))),
                                getResources().getDimensionPixelSize(R.dimen.imgSize),
                                getResources().getDimensionPixelSize(R.dimen.imgSize)
                        );

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = calRatio;
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
                        if(bitmap != null){
                            ImgPath=bitmap;
                            binding.diaryPhotoImage.setImageBitmap(bitmap);
                        }
                    }
                }
        );

        binding.photoBtn.setOnClickListener(view -> {
            try {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                File file = File.createTempFile(
                        "JPEG_"+timeStamp+"_",
                        ".jpg",
                        storageDir
                );
                filePath = file.getAbsolutePath();
                Uri photoURI = FileProvider.getUriForFile(
                        this,
                        "com.numberONE.maryfarm.fileprovider",
                        file
                );
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                cameraFileLauncher.launch(intent);
            }catch (Exception e){
                e.printStackTrace();
            }

        });

        // 갤러리 실행 > 결과값 게시
        ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        int calRatio = calculateInSampleSize(
                                result.getData().getData(),
                                getResources().getDimensionPixelSize(R.dimen.imgSize),
                                getResources().getDimensionPixelSize(R.dimen.imgSize)
                        );

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = calRatio;
                        try{
                            InputStream inputStream = getContentResolver().openInputStream(result.getData().getData());
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                            // inputStream.close();
                            if(bitmap != null){
                                ImgPath=bitmap;
                                binding.diaryPhotoImage.setImageBitmap(bitmap);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

        binding.galleryBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            galleryLauncher.launch(intent);
        });

        // 저장 버튼 클릭 -> DB에 정보를 저장하고 이동
        binding.saveBtn.setOnClickListener(view -> {
            // 비트맵 put할 때 40kb넘어가면 오류생겨서 byte배열로 압축해서 넘겨주기 ㄴㅇ
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImgPath.compress(Bitmap.CompressFormat.PNG,100,stream);
            byte[] bytes= stream.toByteArray();

            // DB저장이 아닌 단순 디테일 페이지로 정보 전달
            Intent intent = new Intent(this, DiaryDetailActivity.class);
            intent.putExtra("image",bytes );
            intent.putExtra("content",binding.editTextBox.getText().toString());
            startActivity(intent);
            Log.d("onCreate: ","데이터 전송완료" );
        });
    }

    private int calculateInSampleSize(Uri fileUri, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            InputStream inputStream = getContentResolver().openInputStream(fileUri);

            //inJustDecodeBounds 값을 true 로 설정한 상태에서 decodeXXX() 를 호출.
            //로딩 하고자 하는 이미지의 각종 정보가 options 에 설정 된다.
            BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.close();
            inputStream = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //비율 계산........................
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;

        //inSampleSize 비율 계산
        if (height > reqHeight || width > reqWidth) {

            int halfHeight = height / 2;
            int halfWidth = width / 2;

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
