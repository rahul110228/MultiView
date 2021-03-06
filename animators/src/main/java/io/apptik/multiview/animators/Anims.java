/*
 * Copyright (C) 2015 AppTik Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apptik.multiview.animators;


import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

public class Anims {

    private Anims() {
        throw new IllegalStateException("no instances");
    }

    public static ViewPropertyAnimatorCompat fadeOut(View view) {
        return ViewCompat.animate(view).alpha(0);
    }

    public static ViewPropertyAnimatorCompat fadeIn(View view) {
        return ViewCompat.animate(view).alpha(1);
    }

    public static ViewPropertyAnimatorCompat defaultMoveAnim(View view) {
        return ViewCompat.animate(view).translationX(0).translationY(0);
    }

    public static ViewPropertyAnimatorCompat defaultChangeOldViewAnim(
            View view, final BaseItemAnimator.ChangeInfo changeInfo) {
        return ViewCompat.animate(view)
                .translationX(changeInfo.toX - changeInfo.fromX)
                .translationY(changeInfo.toY - changeInfo.fromY)
                .alpha(0);
    }

    public static ViewPropertyAnimatorCompat defaultChangeNewViewAnim(
            View view, final BaseItemAnimator.ChangeInfo changeInfo) {
        return ViewCompat.animate(view)
                .translationX(0)
                .translationY(0)
                .alpha(1);
    }

    public static ViewPropertyAnimatorCompat teleportChangeOldViewAnim(
            View view, final BaseItemAnimator.ChangeInfo changeInfo) {
        return ViewCompat.animate(view)
                .scaleX(0)
                .scaleY(0)
                .alpha(0);
    }

    public static ViewPropertyAnimatorCompat teleportChangeNewViewAnim(
            View view, final BaseItemAnimator.ChangeInfo changeInfo) {
        return ViewCompat.animate(view)
                .scaleX(1)
                .scaleY(1)
                .alpha(1);
    }


    public static ViewPropertyAnimatorCompat garageDoorClose(final View view) {
        return ViewCompat.animate(view)
                .rotationX(0)
                .translationY(0);
    }

    public static ViewPropertyAnimatorCompat garageDoorOpen(final View view) {
        return ViewCompat.animate(view)
                .rotationX(90)
                .translationY(-(view.getMeasuredHeight() / 2));
    }

    public static ViewPropertyAnimatorCompat slideInHorisontal(final View view) {
        return ViewCompat.animate(view).translationX(0);
    }

    public static ViewPropertyAnimatorCompat slideOutRight(final View view) {
        return ViewCompat.animate(view).translationX(view.getRootView().getWidth());
    }

    public static ViewPropertyAnimatorCompat slideOutLeft(final View view) {
        return ViewCompat.animate(view).translationX(-view.getRootView().getWidth());
    }

    public static ViewPropertyAnimatorCompat slideOutTop(final View view) {
        return ViewCompat.animate(view).translationY(view.getRootView().getHeight());
    }

    public static ViewPropertyAnimatorCompat slideInVertical(final View view) {
        return ViewCompat.animate(view).translationY(0);
    }

    public static ViewPropertyAnimatorCompat slideOutBottom(final View view) {
        return ViewCompat.animate(view).translationY(-view.getRootView().getHeight());
    }

    public static ViewPropertyAnimatorCompat zoom2Normal(final View view) {
        return ViewCompat.animate(view).scaleX(1).scaleY(1);
    }

    public static ViewPropertyAnimatorCompat zoomOut(final View view) {
        return ViewCompat.animate(view).scaleX(0).scaleY(0);
    }

    public static ViewPropertyAnimatorCompat zoomIn(final View view) {
        return ViewCompat.animate(view).scaleX(10).scaleY(10).alpha(0);
    }


    /////
    public static ViewPropertyAnimatorCompat flipDownIn(final View view) {
        return ViewCompat.animate(view).withStartAction(
                new Runnable() {
                    @Override
                    public void run() {
                        ViewCompat.setTranslationX(view, -(view.getMeasuredWidth() / 2));
                        ViewCompat.setRotationY(view, -90);
                    }
                })
                .rotationY(0)
                .translationX(0)
                .setInterpolator(new BounceInterpolator());
    }

    public static ViewPropertyAnimatorCompat flipDownOut(final View view) {
        return ViewCompat.animate(view)
                .rotationY(90)
                .translationX(-(view.getMeasuredWidth() / 4))
                .scaleX(0.5F)
                .scaleY(0.5F)
                .setInterpolator(new AccelerateInterpolator());
    }


    public static ViewPropertyAnimatorCompat flipExitBottom(final View view) {
        return ViewCompat.animate(view)
                .rotationX(-90);
    }

    public static ViewPropertyAnimatorCompat flipEnterVertical(final View view) {
        return ViewCompat.animate(view).rotationX(0);
    }

    public static ViewPropertyAnimatorCompat flipExitTop(final View view) {
        return ViewCompat.animate(view)
                .rotationX(90);
    }

    public static ViewPropertyAnimatorCompat flipExitRight(final View view) {
        return ViewCompat.animate(view)
                .rotationY(-90);
    }

    public static ViewPropertyAnimatorCompat flipEnterHorizontal(final View view) {
        return ViewCompat.animate(view).rotationY(0);
    }

    public static ViewPropertyAnimatorCompat flipExitLeft(final View view) {
        return ViewCompat.animate(view)
                .rotationY(90);
    }


}
