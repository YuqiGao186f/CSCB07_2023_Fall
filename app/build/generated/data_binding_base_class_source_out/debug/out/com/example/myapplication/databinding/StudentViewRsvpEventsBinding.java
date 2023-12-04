// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
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

public final class StudentViewRsvpEventsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnStudentViewAnnouncementEventBack;

  @NonNull
  public final RelativeLayout loginBackground;

  @NonNull
  public final ListView studentRsvpEventList;

  @NonNull
  public final TextView studentSelectRsvpEvent;

  private StudentViewRsvpEventsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnStudentViewAnnouncementEventBack, @NonNull RelativeLayout loginBackground,
      @NonNull ListView studentRsvpEventList, @NonNull TextView studentSelectRsvpEvent) {
    this.rootView = rootView;
    this.btnStudentViewAnnouncementEventBack = btnStudentViewAnnouncementEventBack;
    this.loginBackground = loginBackground;
    this.studentRsvpEventList = studentRsvpEventList;
    this.studentSelectRsvpEvent = studentSelectRsvpEvent;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static StudentViewRsvpEventsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static StudentViewRsvpEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.student_view_rsvp_events, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static StudentViewRsvpEventsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnStudentViewAnnouncementEventBack;
      Button btnStudentViewAnnouncementEventBack = ViewBindings.findChildViewById(rootView, id);
      if (btnStudentViewAnnouncementEventBack == null) {
        break missingId;
      }

      id = R.id.login_background;
      RelativeLayout loginBackground = ViewBindings.findChildViewById(rootView, id);
      if (loginBackground == null) {
        break missingId;
      }

      id = R.id.studentRsvpEventList;
      ListView studentRsvpEventList = ViewBindings.findChildViewById(rootView, id);
      if (studentRsvpEventList == null) {
        break missingId;
      }

      id = R.id.studentSelectRsvpEvent;
      TextView studentSelectRsvpEvent = ViewBindings.findChildViewById(rootView, id);
      if (studentSelectRsvpEvent == null) {
        break missingId;
      }

      return new StudentViewRsvpEventsBinding((ConstraintLayout) rootView,
          btnStudentViewAnnouncementEventBack, loginBackground, studentRsvpEventList,
          studentSelectRsvpEvent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}