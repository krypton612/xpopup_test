package com.propup.xoclsq1;

import static com.propup.xoclsq1.XPopupApp.context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.animation.FloatEvaluator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.interfaces.OnConfirmListener;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lxj.xpopup.interfaces.SimpleCallback;
import com.propup.xoclsq1.custom.PagerDrawe;
import com.propup.xoclsq1.custom.emergent;
import com.propup.xoclsq1.custom.notification_popup;

/*
    Nota 1.0.0 ->

        dentro de getContext puede ir el contexto directamenta de la actividad
        o simplemente tambien poner el contexto del boton al que va dirigido el
        evento click o el que use

    <- Nota


 */
public class MainActivity extends AppCompatActivity {

    private  Button estilo1;
    private  Button estilo2;
    private  Button estilo3;
    private  Button estilo4;
    private  Button estilo5;
    private  Button estilo6;
    private  Button estilo7;
    private  Button estilo8;
    private  Button estilo9;
    private  Button estilo10;
    private  Button estilo11;
    private  Button estilo12;

    BasePopupView popupView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int nightModeFlags = MainActivity.this.getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {

            case Configuration.UI_MODE_NIGHT_YES:

                break;

            case Configuration.UI_MODE_NIGHT_NO:

                break;
        }


        estilo1 = findViewById(R.id.estilo1);
        estilo2 = findViewById(R.id.estilo2);
        estilo3 = findViewById(R.id.estilo3);
        estilo4 = findViewById(R.id.estilo4);
        estilo5 = findViewById(R.id.estilo5);
        estilo6 = findViewById(R.id.estilo6);
        estilo7 = findViewById(R.id.estilo7);
        estilo8 = findViewById(R.id.estilo8);
        estilo9 = findViewById(R.id.estilo9);
        estilo10 = findViewById(R.id.estilo10);
        estilo11 = findViewById(R.id.estilo11);
        estilo12 = findViewById(R.id.estilo12);

        estilo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(estilo1.getContext()).asConfirm("Aceptas", "perro",
                                new OnConfirmListener() {
                                    @Override
                                    public void onConfirm() {
                                        Toast.makeText(MainActivity.this, " click en si ", Toast.LENGTH_LONG).show();
                                    }
                                })
                        .show();

            }
        });

        estilo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(estilo2.getContext()).asInputConfirm("escribe", "mierda",
                                new OnInputConfirmListener() {
                                    @Override
                                    public void onConfirm(String text) {
                                        Toast.makeText(MainActivity.this, " escribiste "+ text, Toast.LENGTH_LONG).show();
                                    }
                                })
                        .show();
            }
        });
        estilo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(estilo3.getContext())
                        //.maxWidth(600)
                        .asCenterList("escoje una puta", new String[]{"puta 1", "puta 2", "puta 3", "puta 4"},
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        Toast.makeText(MainActivity.this, " te gusta la "+ text, Toast.LENGTH_LONG).show();
                                    }
                                })
                        .show();
            }
        });
        estilo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(estilo4.getContext())
                        .asLoading("cargando..")
                        .show();


            }

        });

        estilo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(estilo5.getContext())
                        .asBottomList("escoje una puta", new String[]{"puta 1", "puta 2", "puta 3", "puta 4"},
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        Toast.makeText(MainActivity.this, " te gusta la "+ text, Toast.LENGTH_LONG).show();
                                    }
                                })
                        .show();
            }
        });

        estilo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new XPopup.Builder(estilo6.getContext())
                        .atView(view)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
                        .asAttachList(new String[]{"cagada", "joder", "este es icon"},
                                new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher},
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        Toast.makeText(MainActivity.this, " escojiste"+ text + " en la posicion "+ position, Toast.LENGTH_LONG).show();
                                    }
                                })
                        .show();
            }
        });

        final XPopup.Builder builder = new XPopup.Builder(MainActivity.this)
                .watchView(estilo7.findViewById(R.id.estilo7));

        estilo7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                builder.asAttachList(new String[]{"置顶", "复制", "删除"}, null,
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        Toast.makeText(MainActivity.this, " escojiste"+ text + " en la posicion "+ position, Toast.LENGTH_LONG).show();

                                    }
                                })
                        .show();
                return false;
            }
        });

        // con tiempo limitado

        BasePopupView xpopup = new XPopup.Builder(MainActivity.this).asLoading(); // se crea un objeto
        // para añadirlo dentro de cierta accion especifica

        estilo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                xpopup.show();
                xpopup.delayDismiss(2000); // metodo para cerrar las ventanas con un tiempo determinado

            }
        });

        estilo9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new XPopup.Builder(MainActivity.this)
//                        .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                        .offsetY(300)
                        .offsetX(-100)
                        .popupAnimation(PopupAnimation.TranslateFromLeft)
                        .asCustom(new emergent(MainActivity.this))
                        .show();
            }
        });

        estilo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(MainActivity.this)
                        .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
                        .popupAnimation(PopupAnimation.TranslateFromTop)
                        .asCustom(new notification_popup(MainActivity.this))
                        .show();
            }
        });
        estilo11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(MainActivity.this)
                        .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
//                        .asCustom(new CustomDrawerPopupView(getContext()))
//                        .hasShadowBg(false)
                        .isViewMode(true) //使用了Fragment，必须开启View模式
                        .asCustom(new PagerDrawe(MainActivity.this))
//                        .asCustom(new ListDrawerPopupView(getContext()))
                        .show();
            }
        });
        estilo12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new XPopup.Builder(MainActivity.this)
                        .popupAnimation(PopupAnimation.ScaleAlphaFromCenter)
                        .asCustom(new BasePopupView(MainActivity.this) {
                            @Override
                            protected int getInnerLayoutId() {
                                return R.layout.custom_model_popup;
                            }
                        })
                        .show();
            }
        });


    }
    static class DemoXPopupListener extends SimpleCallback {
        FloatEvaluator fEvaluator = new FloatEvaluator();
        FloatEvaluator iEvaluator = new FloatEvaluator();

        @Override
        public void onCreated(BasePopupView pv) {
            Log.e("tag", "onCreated");
        }

        @Override
        public void onShow(BasePopupView popupView) {
            Log.e("tag", "onShow");
        }

        @Override
        public void onDismiss(BasePopupView popupView) {
            Log.e("tag", "onDismiss");
        }

        @Override
        public void beforeDismiss(BasePopupView popupView) {
            Log.e("tag", "beforeDismiss");
        }

        //如果你自己想拦截返回按键事件，则重写这个方法，返回true即可
        @Override
        public boolean onBackPressed(BasePopupView popupView) {
            Log.e("tag", "拦截的返回按键，按返回键XPopup不会关闭了");
            Toast.makeText(popupView.getContext(), "onBackPressed返回true，拦截了返回按键，按返回键XPopup不会关闭了", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public void onDrag(BasePopupView popupView, int value, float percent, boolean upOrLeft) {
            super.onDrag(popupView, value, percent, upOrLeft);
            Log.e("tag", "value: " + value + "  percent: " + percent);
//            ((Activity) popupView.getContext()).getWindow().getDecorView().setTranslationX(value);
//            float e = fEvaluator.evaluate(percent, 1.0, 0.8);
//            View decorView = ((Activity) popupView.getContext()).getWindow().getDecorView();
//            decorView.setScaleX(e);
//            decorView.setScaleY(e);
//            FloatEvaluator iEvaluator = new FloatEvaluator();
//            View decorView = ((Activity) popupView.getContext()).getWindow().getDecorView();
//            float t = iEvaluator.evaluate(percent, 0, -popupView.getMeasuredWidth()/2);
//            decorView.setTranslationX(t);
        }

        @Override
        public void onKeyBoardStateChanged(BasePopupView popupView, int height) {
            super.onKeyBoardStateChanged(popupView, height);
            Log.e("tag", "onKeyBoardStateChanged height: " + height);
        }

        @Override
        public void onClickOutside(BasePopupView popupView) {
            super.onClickOutside(popupView);
            Log.e("tag", "onClickOutside");
        }
    }
}