import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { NgJhipsterModule } from 'ng-jhipster';

import { InventorySharedModule } from 'app/shared';
import { InventoryCoreModule } from 'app/core';
import { InventoryAppRoutingModule } from './app-routing.module';
import { InventoryHomeModule } from './home/home.module';
import { InventoryEntityModule } from './entities/entity.module';
import * as moment from 'moment';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent, NavbarComponent, FooterComponent, ErrorComponent } from './layouts';

@NgModule({
  imports: [
    BrowserModule,
    NgxWebstorageModule.forRoot({ prefix: 'jhi', separator: '-' }),
    NgJhipsterModule.forRoot({
      // set below to true to make alerts look like toast
      alertAsToast: false,
      alertTimeout: 5000
    }),
    InventorySharedModule.forRoot(),
    InventoryCoreModule,
    InventoryHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    InventoryEntityModule,
    InventoryAppRoutingModule
  ],
  declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, FooterComponent],
  providers: [],
  bootstrap: [JhiMainComponent]
})
export class InventoryAppModule {
  constructor(private dpConfig: NgbDatepickerConfig) {
    this.dpConfig.minDate = { year: moment().year() - 100, month: 1, day: 1 };
  }
}
