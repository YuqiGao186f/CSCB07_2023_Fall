package com.example.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.function.Consumer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    @Mock
    MainActivity view;

    @Mock
    Model model;

    @Captor
    ArgumentCaptor<Consumer<User>> captor;

    @Test
    public void testPresenter1(){
        // Test login as Admin successfully

        String email = "admin@mail.com";
        String password = "123456";

        Admin admin = new Admin();

        Presenter presenter = new Presenter(model, view);
        presenter.login(email, password);

        // verify if model.authenticate() has run
        verify(model).authenticate(eq(email), eq(password), captor.capture());
        Consumer<User> callback = captor.getValue();
        callback.accept(admin);

        // verify if view.redirectToPatientDashboard has run
        verify(view, times(1)).redirectToAdminOperations(any());
    }

    @Test
    public void testPresenter2(){
        // Test failed to login as Admin
        // Caused by unregistered or incorrect email/password input
        // All of the failed reasons above will callback null to presenter

        String email = "unregisteredadmin@mail.com";
        String password = "123456";

        Admin admin = null;

        Presenter presenter = new Presenter(model, view);
        presenter.login(email, password);

        // verify if model.authenticate() has run
        verify(model).authenticate(eq(email), eq(password), captor.capture());
        Consumer<User> callback = captor.getValue();
        callback.accept(admin);

        // verify if view.redirectToPatientDashboard has run
        verify(view, times(0)).redirectToAdminOperations(any());
    }

    public void testPresenter3(){
        // Test login as Student successfully

        String email = "student@mail.com";
        String password = "123456";

        Student student = new Student();

        Presenter presenter = new Presenter(model, view);
        presenter.login(email, password);

        // verify if model.authenticate() has run
        verify(model).authenticate(eq(email), eq(password), captor.capture());
        Consumer<User> callback = captor.getValue();
        callback.accept(student);

        // verify if view.redirectToPatientDashboard has run
        verify(view, times(1)).redirectToStudentOperations(any());
    }

    @Test
    public void testPresenter4(){
        // Test failed to login as Student
        // Caused by unregistered or incorrect email/password input
        // All of the failed reasons above will callback null to presenter

        String email = "unregisteredstudent@mail.com";
        String password = "123456";

        Student student = null;

        Presenter presenter = new Presenter(model, view);
        presenter.login(email, password);

        // verify if model.authenticate() has run
        verify(model).authenticate(eq(email), eq(password), captor.capture());
        Consumer<User> callback = captor.getValue();
        callback.accept(student);

        // verify if view.redirectToPatientDashboard has run
        verify(view, times(0)).redirectToStudentOperations(any());
    }
}