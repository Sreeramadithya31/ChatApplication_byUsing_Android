package com.example.chatapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.graphics.Color;

public class MainActivity extends Activity {
    private LinearLayout messages;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        messages = findViewById(R.id.messages);
        EditText input = findViewById(R.id.messageInput);
        Button send = findViewById(R.id.sendButton);
        send.setOnClickListener(v -> {
            String text = input.getText().toString().trim();
            if (!text.isEmpty()) {
                addMessage("You: " + text);
                input.setText("");
            }
        });
        addMessage("Welcome! This UI demo stores messages only for this session.");
        // TODO: Replace local display with Firebase Authentication + Realtime Database.
    }

    private void addMessage(String text) {
        TextView item = new TextView(this);
        item.setText(text);
        item.setTextSize(16);
        item.setTextColor(Color.DKGRAY);
        item.setPadding(12, 10, 12, 10);
        messages.addView(item, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
