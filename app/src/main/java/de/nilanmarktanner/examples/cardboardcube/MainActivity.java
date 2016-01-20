package de.nilanmarktanner.examples.cardboardcube;

import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;

public class MainActivity extends CardboardActivity {
    private SceneRenderer sceneRenderer;
    private Vibrator vibrator;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_ui);
        CardboardView cardboardView = (CardboardView) findViewById(R.id.cardboard_view);
        // enable for performance boost - make sure to reset state before drawing yourself
        // cardboardView.setRestoreGLStateEnabled(false);
        sceneRenderer = new SceneRenderer();
        cardboardView.setRenderer(sceneRenderer);
        setCardboardView(cardboardView);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    @Override
    public void onCardboardTrigger() {
        // trigger the renderer
        sceneRenderer.trigger();

        // Give user feedback.
        vibrator.vibrate(50);
    }
}
