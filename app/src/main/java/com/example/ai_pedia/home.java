package com.example.ai_pedia;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<CardViewItem> dataList;
    private EditText searchEditText;
    Button cat,logoutBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_color));
        }
        setContentView(R.layout.activity_home);
        cat = findViewById(R.id.btn2);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getApplicationContext(),category.class);
                startActivity(i1);
            }
        });
        auth = FirebaseAuth.getInstance();

        cat = findViewById(R.id.btn2);
        logoutBtn = findViewById(R.id.logoutBtn);

        // Handle click event for the logout button
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out the user from Firebase
                auth.signOut();

                // Redirect to the signin activity
                Intent intent = new Intent(getApplicationContext(), signin.class);
                startActivity(intent);
                finish();
            }
        });
        FirebaseUser user = auth.getCurrentUser();
        if (user == null) {
            // If the user is not signed in, redirect to the signin activity
            Intent intent = new Intent(getApplicationContext(), signin.class);
            startActivity(intent);
            finish();
        }

        recyclerView = findViewById(R.id.recyclerView);
        searchEditText = findViewById(R.id.searchEditText);

        // Create a list of CardViewItem objects with image, title, description, and activity class
        dataList = new ArrayList<>();
        dataList.add(new CardViewItem(R.drawable.writesonic1, "Whitesonic", "text copywriting SEO writing`", card1.class));
        dataList.add(new CardViewItem(R.drawable.rytr1, "Rytr", "email assistant copywriting", card2.class));
        dataList.add(new CardViewItem(R.drawable.chatgptwriter1, "ChatGPT Writer", "productivity email text", card3.class));
        dataList.add(new CardViewItem(R.drawable.notion1, "Notion", "general writing productivity", card4.class));
        dataList.add(new CardViewItem(R.drawable.tome, "Tome", "story teller presentation startup start-up tools ppt", card5.class));
        dataList.add(new CardViewItem(R.drawable.glasp1, "Glasp", "general writing memory highlighting reads", card6.class));
        dataList.add(new CardViewItem(R.drawable.nightcafe1, "NightCafe Studio", "image editng avatars", card7.class));
        dataList.add(new CardViewItem(R.drawable.photoai, "Photo AI", "art designing", card8.class));
        dataList.add(new CardViewItem(R.drawable.magnify, "Magify.design", "image editing", card9.class));
        dataList.add(new CardViewItem(R.drawable.autodraw, "Auto Draw", "designing", card10.class));
        dataList.add(new CardViewItem(R.drawable.stablediffusion, "Stable Diffusion", "image generator developer", card11.class));
        dataList.add(new CardViewItem(R.drawable.scribblediffusion, "Scribble Diffusion", "image generator developer fun drawing image", card12.class));
        dataList.add(new CardViewItem(R.drawable.quriosity, "Quriosity", "personalized videos education assistant", card13.class));
        dataList.add(new CardViewItem(R.drawable.caputrelab, "Caputrelab", "video editing social media gaming", card14.class));
        dataList.add(new CardViewItem(R.drawable.shortai, "2Short.ai", "video editing social media", card15.class));
        dataList.add(new CardViewItem(R.drawable.fliki, "Fliki", "video editing text to speech", card16.class));
        dataList.add(new CardViewItem(R.drawable.xpression, "Xpression Camera", "avatars video generator", card17.class));
        dataList.add(new CardViewItem(R.drawable.krisp, "Krisp", "audio editing productivity", card18.class));
        dataList.add(new CardViewItem(R.drawable.audyo, "Audyo", "audio editing podcast video producer text to speech", card19.class));
        dataList.add(new CardViewItem(R.drawable.adobepodcast, "Adobe Podcast", "audio text to speech", card20.class));
        dataList.add(new CardViewItem(R.drawable.harmonai1, "Harmonai", "music ", card21.class));
        dataList.add(new CardViewItem(R.drawable.riffusion, "Riffusion", "music", card22.class));
        dataList.add(new CardViewItem(R.drawable.boomy1, "Boomy", "music", card23.class));
        dataList.add(new CardViewItem(R.drawable.codeium, "Codeium", "code assitant", card24.class));
        dataList.add(new CardViewItem(R.drawable.marsai1, "MarsAi", "code developer tools low code low-code no code no-code", card25.class));
        dataList.add(new CardViewItem(R.drawable.safurai, "Safurai", "code developer tools", card26.class));
        dataList.add(new CardViewItem(R.drawable.replit1, "Replit", "code", card27.class));
        dataList.add(new CardViewItem(R.drawable.airops, "Airops", "SQL", card28.class));
        dataList.add(new CardViewItem(R.drawable.pixelaai, "Pixela AI", "3D", card29.class));
        dataList.add(new CardViewItem(R.drawable.get3d, "GET3D (Nvidia)", "3D designing models texture", card30.class));
        dataList.add(new CardViewItem(R.drawable.getfloorplan, "GetFloorPlan", "3D real estate home design house design", card31.class));
        dataList.add(new CardViewItem(R.drawable.imgcreator, "Img Creator", "e-commerce e commerce", card32.class));
        dataList.add(new CardViewItem(R.drawable.producrbot1, "ProductBot", "e-commerce e commerce life ", card33.class));
        dataList.add(new CardViewItem(R.drawable.wisdolia, "Wisdolia", "education memory", card34.class));
        dataList.add(new CardViewItem(R.drawable.wolframalpha1, "WolframAlpha", "education research", card35.class));
        dataList.add(new CardViewItem(R.drawable.humataai, "Humata AI", "legal education research", card36.class));
        dataList.add(new CardViewItem(R.drawable.chekforai, "Checkfor AI", "SEO education", card37.class));
        // Add more items as needed

        adapter = new RecyclerViewAdapter(dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Add a text change listener to the searchEditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Call a method to filter the data based on the search query
                filterData(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void filterData(String query) {
        List<CardViewItem> filteredList = new ArrayList<>();
        for (CardViewItem item : dataList) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.setData(filteredList);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List<CardViewItem> dataList;

        public RecyclerViewAdapter(List<CardViewItem> dataList) {
            this.dataList = dataList;
        }

        public void setData(List<CardViewItem> dataList) {
            this.dataList = dataList;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final CardViewItem item = dataList.get(position);
            holder.imageView.setImageResource(item.getImageResource());
            holder.titleTextView.setText(item.getTitle());
            holder.descriptionTextView.setText(item.getDescription());

            // Set click listener for the card view
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Launch the respective activity based on the card clicked
                    Intent intent = new Intent(home.this, item.getActivityClass());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            CardView cardView;
            ImageView imageView;
            TextView titleTextView;
            TextView descriptionTextView;

            ViewHolder(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.card_view);
                imageView = itemView.findViewById(R.id.imageView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            }
        }
    }
}
