package com.example.aurel.app_project;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEdition;
    RecyclerView recyclerView;
    NameListAdapter nameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        nameListAdapter.updateList(DataManager.getInstance().getNameList());
    }

    private void initViews(){
        buttonEdition = findViewById(R.id.activity_main_button_edit);
        recyclerView = findViewById(R.id.activity_main_recyclerview);

        buttonEdition.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.activity_main_button_edit:
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initList(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK && data.getExtras() != null){
                Bundle args = data.getExtras();
                String name = args.getString("USERNAME");

                Log.d("USERNAME", name);
            } else {
                // handle error
            }
        }
    }
}
