package topteam.com.sql_demo02;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText id1_v;
    EditText name1_v;
    EditText name2_v;
    EditText jq1_v;
    EditText jq2_v;
    EditText ys1_v;
    EditText ys2_v;
    Button add_v;
    Button up_v;
    Button sele_v;
    Button dele_v;
    TextView show_v;
    Context context;
    StringBuilder sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        initView();
        context = MainActivity.this;
        LitePal.getDatabase();

    }

    /**
     * 初始化所有控件
     */
    private void initView() {
         id1_v = findViewById(R.id.id1);
         name1_v = findViewById(R.id.name1);
         name2_v = findViewById(R.id.name2);
         jq1_v = findViewById(R.id.jq1);
         jq2_v = findViewById(R.id.jq2);
         ys1_v = findViewById(R.id.ys1);
         ys2_v = findViewById(R.id.ys2);
        Button add_v = findViewById(R.id.add);
        Button up_v = findViewById(R.id.up);
        Button sele_v = findViewById(R.id.selet);
        Button dele_v = findViewById(R.id.dele);
        add_v.setOnClickListener(this);
        up_v.setOnClickListener(this);
        dele_v.setOnClickListener(this);
        sele_v.setOnClickListener(this);
        show_v = findViewById(R.id.show);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                  int id = Integer.parseInt(id1_v.getText().toString());
                  String name = name1_v.getText().toString();
                  int pag = Integer.parseInt(ys1_v.getText().toString());
                  double price = Double.parseDouble(jq1_v.getText().toString());
                  Book book = new Book();
                  book.setId(id);
                  book.setName(name);
                  book.setPag(pag);
                  book.setPrice(price);
                  book.save();
                  show_v.setText("添加成功");
                break;
            case R.id.up:
                int id1 = Integer.parseInt(id1_v.getText().toString());
                String name1 = name1_v.getText().toString();
                int pag1 = Integer.parseInt(ys1_v.getText().toString());
                double price1 = Double.parseDouble(jq1_v.getText().toString());
                Book book1 = new Book();
                book1.setPrice(price1);
                book1.updateAll("name=?",name1);
                show_v.setText("修改成功");
                break;
            case R.id.selet:
                sb = new StringBuilder();
                List<Book> books = DataSupport.findAll(Book.class);
                for(Book bk:books){
                    sb.append(bk.getId()+" "+bk.getName()+"  "+bk.getPag()+" "+bk.getPrice()+"\n");
                }
                show_v.setText(sb.toString());
                break;
            case R.id.dele:
                String name2 = name1_v.getText().toString();
                DataSupport.deleteAll(Book.class,"name=?",name2);
                show_v.setText("删除成功成功");
                break;
            default:
                break;
        }
    }
}
