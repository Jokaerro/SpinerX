package pro.games_box.spinerx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> myList1;
    private ListPopupWindow mListPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initList();

        ImageView iv = (ImageView) toolbar.findViewById(R.id.toc);

        mListPopupWindow = new ListPopupWindow(this);
        mListPopupWindow.setAnchorView(iv);
        mListPopupWindow.setWidth(600);
        mListPopupWindow.setHeight(400);
        mListPopupWindow.setAdapter(
                new ArrayAdapter<>(
                getBaseContext(),
                R.layout.spinner_row, R.id.category_name_tv , myList1));
        mListPopupWindow.setModal(true);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListPopupWindow.show();
            }
        });

        mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkbox = (CheckBox) view.findViewById(R.id.check);
                checkbox.toggle();
                Log.e("tagg====", myList1.get(position) + " " + checkbox.isChecked());
            }
        });
        mListPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Log.e("tagg====", "DISMIS");
            }
        });
        mListPopupWindow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("tagg====", "sleect");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.e("tagg====", "nothing");
            }
        });


        TextView hello = (TextView) findViewById(R.id.hello);
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String s = spinner.getSelectedItemsAsString();
//                Log.e("getSelected", s);
            }
        });

    }

    void initList() {
        myList1 = new ArrayList<String>();
        myList1.add("Понедельник");
        myList1.add("Вторник");
        myList1.add("Среда");
        myList1.add("Четверг");
        myList1.add("Котопятница");
        myList1.add("Субкота");
        myList1.add("Воскресенье");
    }

}
