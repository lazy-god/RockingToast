package com.pratap.ninja.rockingtoastapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by darsh on 01-11-2017.
 */

public class ToastCreator {

    public static final Integer TOAST_SHORT = 0;
    public static final Integer TOAST_LONG = 1;
    public static final Float DEFAULT_TEXT = 16f;
    public static final Integer SIMPLE_TOAST = 11;
    public static final Integer ERROR_TOAST = 12;
    public static final Integer SUCCESS_TOAST = 13;
    public static final Integer WARNING_TOAST = 14;
    public static final Integer UP_TOAST = 15;
    public static final Integer SHAKY_ANIM = 17;
    public static final Integer BOUNCY_ANIM = 18;
    public static final Integer CIRCULAR_ANIM = 19;
    public static final Integer BLINKY_ANIM = 20;
    public static final Integer NO_ANIM = 21;
    public static final Integer NO_IMAGE = 22;
    private LayoutInflater inflater;
    private View layout;
    private TextView text;
    private Toast toast;
    private LinearLayout ll;
    private GradientDrawable gradientDrawable;
    private ImageView iv;

    private Activity activity;
    private Animation a;

    public ToastCreator(Activity activity) {
        this.activity = activity;
    }

    public Toast makeRockingCustomToast(Integer ToastType, String message, Integer duration) {
        switch(ToastType) {
            case 11: Toast.makeText(activity, message, duration).show();
                break;

            case 12: inflater = activity.getLayoutInflater();
                layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) activity.findViewById(R.id.container_1));

                ll = layout.findViewById(R.id.container_1);
                gradientDrawable = (GradientDrawable) ll.getBackground();
                gradientDrawable.setColor(Color.RED);
                gradientDrawable.setStroke(0, Color.BLACK);
                gradientDrawable.setCornerRadius(80f);

                iv = layout.findViewById(R.id.iv_1);
                iv.setImageResource(R.drawable.ic_error_outline_white_24dp);
                iv.setAnimation(BlinkyAnimation());
                text = layout.findViewById(R.id.text_1);
                text.setTextColor(Color.WHITE);
                text.setTextSize(16f);
                text.setTypeface(Typeface.DEFAULT_BOLD);
                text.setText(message);

                toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(duration);
                toast.setView(layout);
//                toast.show();
                break;

            case 13: inflater = activity.getLayoutInflater();
                layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) activity.findViewById(R.id.container_1));

                ll = layout.findViewById(R.id.container_1);
                gradientDrawable = (GradientDrawable) ll.getBackground();
                gradientDrawable.setColor(activity.getResources().getColor(android.R.color.holo_green_dark));
                gradientDrawable.setStroke(0, Color.BLACK);
                gradientDrawable.setCornerRadius(80f);

                iv = layout.findViewById(R.id.iv_1);
                iv.setImageResource(R.drawable.ic_done_white_24dp);
                iv.setAnimation(BouncyAnimation());
                text = layout.findViewById(R.id.text_1);
                text.setTextColor(Color.WHITE);
                text.setTypeface(Typeface.SANS_SERIF);
                text.setTextSize(16f);
                text.setText(message);

                toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(duration);
                toast.setView(layout);
//                toast.show();
                break;

            case 14: inflater = activity.getLayoutInflater();
                layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) activity.findViewById(R.id.container_1));

                ll = layout.findViewById(R.id.container_1);
                gradientDrawable = (GradientDrawable) ll.getBackground();
                gradientDrawable.setColor(Color.YELLOW);
                gradientDrawable.setCornerRadius(80f);
                gradientDrawable.setStroke(0, Color.BLACK);

                iv = layout.findViewById(R.id.iv_1);
                iv.setImageResource(R.drawable.ic_warning_black_24dp);
                iv.startAnimation(ShakyAnimation());
                text = layout.findViewById(R.id.text_1);
                text.setTextColor(Color.BLACK);
                text.setTypeface(Typeface.DEFAULT_BOLD);
                text.setTextSize(16f);
                text.setText(message);

                toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(duration);
                toast.setView(layout);
//                toast.show();
                break;

            case 15: inflater = activity.getLayoutInflater();
                layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) activity.findViewById(R.id.container_1));

                ll = layout.findViewById(R.id.container_1);
                gradientDrawable = (GradientDrawable) ll.getBackground();
                gradientDrawable.setColor(activity.getResources().getColor(android.R.color.holo_blue_dark));
                gradientDrawable.setStroke(0, Color.BLACK);
                gradientDrawable.setCornerRadius(80f);

                iv = layout.findViewById(R.id.iv_1);
                iv.setImageResource(R.drawable.ic_refresh_white_24dp);
                iv.setAnimation(CircularAnimation());
                text = layout.findViewById(R.id.text_1);
                text.setTextColor(Color.WHITE);
                text.setTypeface(Typeface.SANS_SERIF);
                text.setTextSize(16f);
                text.setText(message);

                toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(duration);
                toast.setView(layout);
//                toast.show();
                break;
        }
        return toast;
    }


    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(80f);
        gradientDrawable.setStroke(0, Color.BLACK);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(Color.WHITE);
        text.setTextSize(16f);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return  toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Float text_size, Integer text_color, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(80f);
        gradientDrawable.setStroke(0, Color.BLACK);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(text_color);
        text.setTextSize(text_size);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer width_stroke, Integer color_stroke, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(80f);
        gradientDrawable.setStroke(width_stroke, color_stroke);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(Color.WHITE);
        text.setTextSize(16f);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer width_stroke, Integer color_stroke, Float corner_radius, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(corner_radius);
        gradientDrawable.setStroke(width_stroke, color_stroke);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(Color.WHITE);
        text.setTextSize(16f);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer width_stroke, Integer color_stroke, Float corner_radius, Float text_size, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(80f);
        gradientDrawable.setStroke(width_stroke, color_stroke);
        gradientDrawable.setCornerRadius(corner_radius);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(Color.WHITE);
        text.setTextSize(text_size);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer width_stroke, Integer color_stroke, Float corner_radius, Float text_size, Integer text_color, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(corner_radius);
        gradientDrawable.setStroke(width_stroke, color_stroke);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(text_color);
        text.setTextSize(text_size);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer width_stroke, Integer color_stroke, Float corner_radius, Float text_size, Typeface font_type, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(corner_radius);
        gradientDrawable.setStroke(width_stroke, color_stroke);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(Color.WHITE);
        text.setTextSize(text_size);
        text.setTypeface(font_type);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    public Toast makeRockingToast(String message, Integer duration, Integer color, Integer width_stroke, Integer color_stroke, Float corner_radius, Float text_size, Integer text_color, Typeface font_type, Integer image, Integer anim) {

        inflater = activity.getLayoutInflater();

        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) activity.findViewById(R.id.container_1));

        LinearLayout ll = layout.findViewById(R.id.container_1);
        GradientDrawable gradientDrawable = (GradientDrawable) ll.getBackground();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(corner_radius);
        gradientDrawable.setStroke(width_stroke, color_stroke);
        iv = layout.findViewById(R.id.iv_1);
        if (!Objects.equals(image, NO_IMAGE)) {
            iv.setImageResource(image);
        } else {
            iv.setVisibility(View.GONE);
        }
        if (!Objects.equals(anim, NO_ANIM)) {
            switch (anim) {
                case 17: a = ShakyAnimation();
                    break;
                case 18: a = BouncyAnimation();
                    break;
                case 19: a = CircularAnimation();
                    break;
                case 20: a = BlinkyAnimation();
                    break;
            }
            iv.startAnimation(a);
        }

        text = layout.findViewById(R.id.text_1);
        text.setTextColor(text_color);
        text.setTextSize(text_size);
        text.setTypeface(font_type);
        text.setText(message);
        toast = new Toast(activity.getApplicationContext());
//                toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        return toast;

    }

    private Animation ShakyAnimation() {

        RotateAnimation animation3 = new RotateAnimation(-15, 15, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation3.setInterpolator(new AnticipateInterpolator());
        animation3.setRepeatCount(Animation.INFINITE);
        animation3.setRepeatMode(Animation.REVERSE);
        animation3.setDuration(1000);
        return animation3;
    }

    private Animation BouncyAnimation() {

        TranslateAnimation animat = new TranslateAnimation(0, 0, 100, 0);
        animat.setInterpolator(new BounceInterpolator());
        animat.setRepeatCount(Animation.ABSOLUTE);
        animat.setDuration(1000);
        return animat;
    }

    private Animation BlinkyAnimation() {

        AlphaAnimation animation = new AlphaAnimation(1, 0);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(1000);
        return animation;
    }

    private Animation CircularAnimation() {

        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(1000);
        return anim;
    }


}
