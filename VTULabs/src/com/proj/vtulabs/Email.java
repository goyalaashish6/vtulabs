package com.proj.vtulabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText emailid, emailmessage;
	String emailmessage1;
	Button emailsend;
	String emailid1 = "aashish.bangalore@gmail.com";
	String emailid2 = "nnagabharan@gmail.com";

	private void initializeVars() {
		// TODO Auto-generated method stub
		emailmessage = (EditText) findViewById(R.id.emailmessage);
		emailsend = (Button) findViewById(R.id.emailsend);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		emailmessage1 = emailmessage.getText().toString();
		String emailaddress[] = { emailid1, emailid2 };
		Intent i = new Intent(android.content.Intent.ACTION_SEND);
		i.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Message:VTU LABS app");
		i.setType("plain/text");
		i.putExtra(android.content.Intent.EXTRA_TEXT, emailmessage1);
		startActivity(i);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		emailsend.setOnClickListener(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}