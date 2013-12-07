package uz.main.hashchat;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	public static String username = "umair";
	public static String password = "umair";
	private EditText userTxt, pwdTxt;
	private Button btnSignin;
	private ImageSwitcher mImageSwitcher;
	AppSharedPreferences pref;
	Timer t = new Timer();

	private int mPosition = 0;
	private static final int[] IMAGES = { R.drawable.ic_main,
			R.drawable.ic_main2, R.drawable.ic_chat };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		mImageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView imageView = new ImageView(MainActivity.this);
				return imageView;
			}
		});

		mImageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
		mImageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				MainActivity.this.runOnUiThread(new Runnable() {
			            @Override
			            public void run() {
			            	//for (int i = 0; i < 3; i++)
							if(mPosition > 2)
								mPosition = 0;
							mImageSwitcher.setBackgroundResource(IMAGES[mPosition]);
							mPosition += 1;
							//mPosition = (mPosition + 1) % 3;
			            }
			        });
				
				

			}
		}, 0, 1000);

		
		this.btnSignin = (Button) findViewById(R.id.btn_signin);
		this.userTxt = (EditText) findViewById(R.id.txt_username);
		this.pwdTxt = (EditText) findViewById(R.id.txt_pwd);
		pref = new AppSharedPreferences(getApplicationContext());
		this.userTxt.setText(this.pref.getUsername());
		this.pwdTxt.setText(this.pref.getPassword());

		this.btnSignin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (userTxt.getText().toString().equals(MainActivity.username)
						&& pwdTxt.getText().toString()
								.equals(MainActivity.password)) {
					Intent intent = new Intent(getApplicationContext(),
							Views.class);
					pref.saveUsername(userTxt.getText().toString());
					pref.savePassword(pwdTxt.getText().toString());
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(),
							"Wrong username or password", Toast.LENGTH_SHORT)
							.show();
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onSwitch(View view) {

	}

}
