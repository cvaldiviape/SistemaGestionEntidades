import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { httpInterceptorProviders } from './security/interceptors';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { SocketIoModule, SocketIoConfig } from 'ngx-socket-io';
import { environment } from '../environments/environment';

const config: SocketIoConfig = {
	url: environment.endPoint, // socket server url;
	options: {
		transports: ['websocket']
	}
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    SharedModule,
    AppRoutingModule,
    HttpClientModule, 
    SocketIoModule.forRoot(config),
  ],
  providers: [httpInterceptorProviders, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }