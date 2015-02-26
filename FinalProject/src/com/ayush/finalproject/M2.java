package com.ayush.finalproject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class M2 extends Activity{

    
   
	Operations operations;
	private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
	public static final int MEDIA_TYPE_IMAGE = 1;
	private static final String IMAGE_DIRECTORY_NAME = "Camera";
	private ImageView imgPreview;
	Button b1 , b2;
	private Uri fileUri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m2);
		Intent i = getIntent();
		operations = new Operations(this);
		operations.open();
		
		imgPreview = (ImageView)findViewById(R.id.imgPreview);
		b1=(Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				captureImage();
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub 
				EditText text1 = (EditText) findViewById(R.id.editText1);
		 		EditText text2 = (EditText) findViewById(R.id.editText2);
		 		EditText text3 = (EditText) findViewById(R.id.editText3);
		 		EditText text4 = (EditText) findViewById(R.id.editText4);
				String name, rollno, phoneno, class1; 
		 		name = text1.getText().toString();
		 		rollno = text2.getText().toString();
		 		phoneno = text3.getText().toString();
		 		class1 = text4.getText().toString();
		         Long stud = operations.addStudent(name,rollno,phoneno,class1);  
			Intent i2 = new Intent(getApplicationContext(),M3.class);
			startActivity(i2);
			}
		});
		
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelable("file_uri", fileUri);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		fileUri = savedInstanceState.getParcelable("file_uri");
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(getApplicationContext(),"In on activity result", Toast.LENGTH_LONG);
		if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
			Toast.makeText(getApplicationContext(),"In on activity result", Toast.LENGTH_LONG);
			if (resultCode == RESULT_OK) {
				Toast.makeText(getApplicationContext(),"In on activity result first if", Toast.LENGTH_LONG);
				previewCapturedImage();
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(getApplicationContext(),
						"User cancelled image capture", Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(getApplicationContext(),
						"Sorry! Failed to capture image", Toast.LENGTH_SHORT)
						.show();
			}
		
		}
	}
	public void captureImage()
	{
		Intent i1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
		i1.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
		startActivityForResult(i1,CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
	}
	
	private void previewCapturedImage() {
		try {

			imgPreview.setVisibility(View.VISIBLE);

			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 8;

			final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
					options);

			imgPreview.setImageBitmap(bitmap);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public Uri getOutputMediaFileUri(int type) {
		return Uri.fromFile(getOutputMediaFile(type));
	}

	private static File getOutputMediaFile(int type) {

		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
				IMAGE_DIRECTORY_NAME);

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
				Locale.getDefault()).format(new Date());
		File mediaFile;
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "IMG_" + timeStamp + ".jpg");
		 
		

		return mediaFile;
	}
	

}
