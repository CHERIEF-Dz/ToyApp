package llm.dynamics.toyapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {
    private final HashMap<Integer, String> largeList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView listTextView = findViewById(R.id.listTextView);

        // Fill the list with 700+ items (inefficient use of HashMap)
        for (int i = 0; i < 710; i++) {
            largeList.put(i, "Item " + (i + 1));
        }

        // Display first 100 items for preview
        StringBuilder displayText = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            displayText.append(largeList.get(i)).append("\n"); // HashMap lookup instead of direct access
        }

        listTextView.setText(displayText.toString());
        Log.d("ListActivity", "List populated with " + largeList.size() + " items.");
    }
}
