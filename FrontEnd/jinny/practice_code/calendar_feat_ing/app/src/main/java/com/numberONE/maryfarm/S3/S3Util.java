package com.numberONE.maryfarm.S3;


import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;

public class S3Util {

    //    버킷명 : "maryfarm.bucket"
    private String accessKey="AKIA6GNIUYRRMAH6K36J";
    private String secretKey="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";
    private Region region;

    // 생성자 생성 시 초기 Region 설정 : Seoul
    public S3Util(){
        region= Region.getRegion(Regions.AP_NORTHEAST_2);
    }

    /**
     * Overloading ( 매개변수의 형 , 개수를 다르게 설정할 경우
     *       같은 이름의 함수로 중복 정의할 수 있다. 사용할 때 필요한 매개변수만 입력 후 함수사용 )
     *  S3 파일업로드의 uploadWithTransferUtility  오버로딩
     */
    public void uploadWithTransferUtility(Context context, String bucketName, File file,
                                          TransferListener listener){
        this.uploadWithTransferUtility(context,bucketName,null,file,null,listener);
    }

    /**
     *  S3 파일업로드의 uploadWithTransferUtility  오버로딩
     */
    public void uploadWithTransferUtility(Context context,String bucketName,String folder,
                                          File file,TransferListener listener){
        this.uploadWithTransferUtility(context,bucketName,folder,file,null,listener);
    }

    /**
     S3 파일 업로드
     *
     * @param context    Context
     * @param bucketName S3 버킷 이름(/(슬래쉬) 없이)
     * @param folder     버킷 내 폴더 경로(/(슬래쉬) 맨 앞, 맨 뒤 없이)
     * @param fileName   파일 이름
     * @param file       Local 파일 경로
     * @param listener   AWS S3 TransferListener
     */
    public void uploadWithTransferUtility(Context context, String bucketName, @Nullable String folder,
                                          File file ,@Nullable String fileName, TransferListener listener){
        if(TextUtils.isEmpty(accessKey) || TextUtils.isEmpty(secretKey)){
            throw new IllegalArgumentException("엑세스키, 비밀키는 not null 이어야 합니다.");
        }

        AWSCredentials awsCredentials =new BasicAWSCredentials(accessKey, secretKey);

        AmazonS3Client s3Client = new AmazonS3Client(awsCredentials, region);

        TransferUtility transferUtility = TransferUtility.builder()
                .s3Client(s3Client)
                .context(context)
                .build();

        TransferNetworkLossHandler.getInstance(context);

        TransferObserver uploadObserver = transferUtility.upload(
                (TextUtils.isEmpty(folder))
                        ? bucketName
                        : bucketName + "/" + folder,
                (TextUtils.isEmpty(fileName))
                        ? file.getName()
                        : fileName,
                file
        );

        uploadObserver.setTransferListener(listener);
    }

    /**
     * Access, Secret Key 설정
     */
    public S3Util setKeys(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        return this;
    }

    /**
     * Access Key 설정
     */
    public S3Util setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    /**
     * Secret Key 설정
     */
    public S3Util setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    /**
     * Region Enum 으로 Region 설정
     */
    public S3Util setRegion(Regions regionName) {
        this.region = Region.getRegion(regionName);
        return this;
    }

    /**
     * Region Class 로 Region 설정
     */
    public S3Util setRegion(Region region) {
        this.region = region;
        return this;
    }

    /**
     * Singleton Pattern
     */
    public static S3Util getInstance() {
        return LHolder.instance;
    }

    private static class LHolder {
        private static final S3Util instance = new S3Util();
    }
}