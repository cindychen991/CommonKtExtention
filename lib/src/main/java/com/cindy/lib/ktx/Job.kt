package com.cindy.lib.ktx

import android.view.View
import com.cindy.lib.internal.AutoDisposableJob
import kotlinx.coroutines.Job

fun Job.autoDispose(view: View) = AutoDisposableJob(view, this)