package llm.dynamics.toyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TipActivity extends AppCompatActivity {
    private int tipNumber = 1;
    private TextView tipTextView;
    private Button prevButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        tipTextView = findViewById(R.id.tipTextView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        // Get the tip number from Intent (default is 1)
        tipNumber = getIntent().getIntExtra("TIP_NUMBER", 1);

        // Update UI
        updateTip();

        // Previous Button Click
        prevButton.setOnClickListener(view -> {
            if (tipNumber > 1) {
                tipNumber--;
                restartActivity();
            }
        });

        // Next Button Click
        nextButton.setOnClickListener(view -> {
            if (tipNumber < 10) {
                tipNumber++;
                restartActivity();
            } else {
                // Open Second Activity when reaching Tip 10
                startActivity(new Intent(TipActivity.this, ListActivity.class));
            }
        });
    }

    private void updateTip() {
        tipTextView.setText("Tip " + tipNumber + ": Press the Next button to see the next tip");

        // Enable/Disable buttons
        prevButton.setEnabled(tipNumber > 1);
    }

    private void restartActivity() {
        Intent intent = new Intent(this, TipActivity.class);
        intent.putExtra("TIP_NUMBER", tipNumber);
        startActivity(intent);
        finish(); // Close the current activity
    }
}
