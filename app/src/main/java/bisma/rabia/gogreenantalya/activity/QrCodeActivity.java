package bisma.rabia.gogreenantalya.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.ActivityQrCodeBinding;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.TRANSPARENT;

public class QrCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQrCodeBinding activityQrCodeBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_qr_code, null, false);
        setContentView(activityQrCodeBinding.getRoot());

        activityQrCodeBinding.imvQrCode.setImageBitmap(encodeAsBitmap(PreferenceManager.getDefaultSharedPreferences(this).getString("username", "")));

        activityQrCodeBinding.btnQrCodeConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(4321);
                finish();
            }
        });
    }

    Bitmap encodeAsBitmap(String str) {
        if (!TextUtils.isEmpty(str)) {
            BitMatrix result;
            try {
                result = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 500, 500);

                int w = result.getWidth();
                int h = result.getHeight();
                int[] pixels = new int[w * h];
                for (int y = 0; y < h; y++) {
                    int offset = y * w;
                    for (int x = 0; x < w; x++) {
                        pixels[offset + x] = result.get(x, y) ? BLACK : TRANSPARENT;
                    }
                }
                Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                bitmap.setPixels(pixels, 0, 500, 0, 0, w, h);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
