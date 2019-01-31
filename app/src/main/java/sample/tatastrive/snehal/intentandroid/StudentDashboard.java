package sample.tatastrive.snehal.intentandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class StudentDashboard extends AppCompatActivity {
    private android.widget.ImageSwitcher simpleImageSwitcher, simpleImageSwitcher1;

    Button btnNext;


    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5};
    int imageIds1[] = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5};

    int count = imageIds.length;
    int count1 = imageIds1.length;

    // to keep current Index of ImageID array
    int currentIndex = -1;
    int currentIndex1 = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        btnNext = findViewById(R.id.buttonNext);
        simpleImageSwitcher = findViewById(R.id.simpleImageSwitcher);
        simpleImageSwitcher1 = findViewById(R.id.simpleImageSwitcher1);

        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        // set the animation type to ImageSwitcher
        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);



        simpleImageSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView view1 = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                view1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                view1.setLayoutParams(new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return view1;
            }
        });

        simpleImageSwitcher1.setInAnimation(in);
        simpleImageSwitcher1.setOutAnimation(out);
        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                currentIndex1++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count && currentIndex1 == count1)
                    currentIndex=0; currentIndex1 = 0;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
                simpleImageSwitcher1.setImageResource(imageIds1[currentIndex1]); // set the image in ImageSwitcher




            }
        });// ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                currentIndex1++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count && currentIndex1 == count1)
                    currentIndex=0; currentIndex1 = 0;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
                simpleImageSwitcher1.setImageResource(imageIds1[currentIndex1]); // set the image in ImageSwitcher




            }
        });

    }
}
