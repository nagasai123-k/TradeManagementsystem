import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientprofileComponent } from './clientprofile/clientprofile.component';
import { BuystocksComponent } from './buystocks/buystocks.component';
import { SellstocksComponent } from './sellstocks/sellstocks.component';
import { TradehistoryComponent } from './tradehistory/tradehistory.component';
// import { PortfolioComponent } from './portfolio/portfolio.component';
import { LogoutComponent } from './logout/logout.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';



import { DropdownComponent } from './dropdown/dropdown.component';
import { TraderequestComponent } from './traderequest/traderequest.component';
import { SuccessComponent } from './success/success.component';
import { CusttradehistoryComponent } from './custtradehistory/custtradehistory.component';

// import { ChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    DashboardComponent,
    ClientprofileComponent,
    BuystocksComponent,
    SellstocksComponent,
    TradehistoryComponent,
    // PortfolioComponent,
    LogoutComponent,
    DropdownComponent,
    TraderequestComponent,
    SuccessComponent,
    CusttradehistoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
   
   
    RouterModule.forRoot([
      
      {
        path:'login', component:LoginComponent
      },
      {
        path:'',component:IndexComponent
      },
      {
        path:'dashboard',component:DashboardComponent
      },
      {
        path:'clientprofile',component:ClientprofileComponent
      },
      {
        path:'index',component:IndexComponent
      },
      {
        path:'buystocks',component:BuystocksComponent
      },
      {
        path:'sellstocks',component:SellstocksComponent
      },
      {
        path:'clientprofile',component:ClientprofileComponent
      },
      {
        path:'tradehistory',component:TradehistoryComponent
      },
      {
        path:'traderequest',component:TraderequestComponent
      },
      {
        path:'success',component:SuccessComponent
      },
      {
        path:'custtradehistory',component:CusttradehistoryComponent
      }
      
    
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
