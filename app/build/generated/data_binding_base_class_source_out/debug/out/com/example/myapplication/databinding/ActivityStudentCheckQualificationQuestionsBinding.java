// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityStudentCheckQualificationQuestionsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnStudentCheckQuali;

  @NonNull
  public final Button btnStudentCheckQualiBack;

  @NonNull
  public final RelativeLayout loginBackground;

  @NonNull
  public final RadioButton q1False;

  @NonNull
  public final RadioButton q1True;

  @NonNull
  public final RadioButton q2False;

  @NonNull
  public final RadioButton q2True;

  @NonNull
  public final RadioButton q3False;

  @NonNull
  public final RadioButton q3True;

  @NonNull
  public final TextView qualificationBanner;

  @NonNull
  public final RadioGroup radioGroup1;

  @NonNull
  public final RadioGroup radioGroup2;

  @NonNull
  public final RadioGroup radioGroup3;

  @NonNull
  public final TextView studentCheckQualiQ1;

  @NonNull
  public final TextView studentCheckQualiQ2;

  @NonNull
  public final TextView studentCheckQualiQ3;

  private ActivityStudentCheckQualificationQuestionsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnStudentCheckQuali, @NonNull Button btnStudentCheckQualiBack,
      @NonNull RelativeLayout loginBackground, @NonNull RadioButton q1False,
      @NonNull RadioButton q1True, @NonNull RadioButton q2False, @NonNull RadioButton q2True,
      @NonNull RadioButton q3False, @NonNull RadioButton q3True,
      @NonNull TextView qualificationBanner, @NonNull RadioGroup radioGroup1,
      @NonNull RadioGroup radioGroup2, @NonNull RadioGroup radioGroup3,
      @NonNull TextView studentCheckQualiQ1, @NonNull TextView studentCheckQualiQ2,
      @NonNull TextView studentCheckQualiQ3) {
    this.rootView = rootView;
    this.btnStudentCheckQuali = btnStudentCheckQuali;
    this.btnStudentCheckQualiBack = btnStudentCheckQualiBack;
    this.loginBackground = loginBackground;
    this.q1False = q1False;
    this.q1True = q1True;
    this.q2False = q2False;
    this.q2True = q2True;
    this.q3False = q3False;
    this.q3True = q3True;
    this.qualificationBanner = qualificationBanner;
    this.radioGroup1 = radioGroup1;
    this.radioGroup2 = radioGroup2;
    this.radioGroup3 = radioGroup3;
    this.studentCheckQualiQ1 = studentCheckQualiQ1;
    this.studentCheckQualiQ2 = studentCheckQualiQ2;
    this.studentCheckQualiQ3 = studentCheckQualiQ3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStudentCheckQualificationQuestionsBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStudentCheckQualificationQuestionsBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_student_check_qualification_questions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStudentCheckQualificationQuestionsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnStudentCheckQuali;
      Button btnStudentCheckQuali = ViewBindings.findChildViewById(rootView, id);
      if (btnStudentCheckQuali == null) {
        break missingId;
      }

      id = R.id.btnStudentCheckQualiBack;
      Button btnStudentCheckQualiBack = ViewBindings.findChildViewById(rootView, id);
      if (btnStudentCheckQualiBack == null) {
        break missingId;
      }

      id = R.id.login_background;
      RelativeLayout loginBackground = ViewBindings.findChildViewById(rootView, id);
      if (loginBackground == null) {
        break missingId;
      }

      id = R.id.q1False;
      RadioButton q1False = ViewBindings.findChildViewById(rootView, id);
      if (q1False == null) {
        break missingId;
      }

      id = R.id.q1True;
      RadioButton q1True = ViewBindings.findChildViewById(rootView, id);
      if (q1True == null) {
        break missingId;
      }

      id = R.id.q2False;
      RadioButton q2False = ViewBindings.findChildViewById(rootView, id);
      if (q2False == null) {
        break missingId;
      }

      id = R.id.q2True;
      RadioButton q2True = ViewBindings.findChildViewById(rootView, id);
      if (q2True == null) {
        break missingId;
      }

      id = R.id.q3False;
      RadioButton q3False = ViewBindings.findChildViewById(rootView, id);
      if (q3False == null) {
        break missingId;
      }

      id = R.id.q3True;
      RadioButton q3True = ViewBindings.findChildViewById(rootView, id);
      if (q3True == null) {
        break missingId;
      }

      id = R.id.qualificationBanner;
      TextView qualificationBanner = ViewBindings.findChildViewById(rootView, id);
      if (qualificationBanner == null) {
        break missingId;
      }

      id = R.id.radioGroup1;
      RadioGroup radioGroup1 = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup1 == null) {
        break missingId;
      }

      id = R.id.radioGroup2;
      RadioGroup radioGroup2 = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup2 == null) {
        break missingId;
      }

      id = R.id.radioGroup3;
      RadioGroup radioGroup3 = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup3 == null) {
        break missingId;
      }

      id = R.id.studentCheckQualiQ1;
      TextView studentCheckQualiQ1 = ViewBindings.findChildViewById(rootView, id);
      if (studentCheckQualiQ1 == null) {
        break missingId;
      }

      id = R.id.studentCheckQualiQ2;
      TextView studentCheckQualiQ2 = ViewBindings.findChildViewById(rootView, id);
      if (studentCheckQualiQ2 == null) {
        break missingId;
      }

      id = R.id.studentCheckQualiQ3;
      TextView studentCheckQualiQ3 = ViewBindings.findChildViewById(rootView, id);
      if (studentCheckQualiQ3 == null) {
        break missingId;
      }

      return new ActivityStudentCheckQualificationQuestionsBinding((ConstraintLayout) rootView,
          btnStudentCheckQuali, btnStudentCheckQualiBack, loginBackground, q1False, q1True, q2False,
          q2True, q3False, q3True, qualificationBanner, radioGroup1, radioGroup2, radioGroup3,
          studentCheckQualiQ1, studentCheckQualiQ2, studentCheckQualiQ3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
