/*
Copyright (C) 2010-2013 Maksim Petrov

Redistribution and use in source and binary forms, with or without
modification, are permitted for themes, skins, widgets, plugins, applications and other software
which communicate with Poweramp music player application on Android platform.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.maxmpz.poweramp.simplewidgetpack;

import com.maxmpz.poweramp.widgetpackcommon.BaseWidgetProvider;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

public class Application extends android.app.Application {
	private static final String TAG = "Application";
	
	static {
		detectPhoneModelEtc();
	}
	
	private SharedPreferences mPref;

	@Override
	public void onCreate() {
		super.onCreate();
		
		mPref = PreferenceManager.getDefaultSharedPreferences(this);
	}
	
	public final SharedPreferences getSharedPreferences() {
		return mPref;
	}
	
	private static void detectPhoneModelEtc() {
		if("HTC".equalsIgnoreCase(Build.MANUFACTURER) && ("inc".equals(Build.PRODUCT) || Build.PRODUCT != null && Build.PRODUCT.contains("htc"))) {
			// Incredible: man: HTC prod: inc
			// Nexus1:     man: HTC prod: passion
			// other htc   man: HTC prod: htc_
			BaseWidgetProvider.IS_HTC_SENSE = true;
		}
	}
}
