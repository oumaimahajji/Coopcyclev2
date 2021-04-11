import { NgModule } from '@angular/core';

import { SharedModule } from 'app/shared/shared.module';
import { CooperativeComponent } from './list/cooperative.component';
import { CooperativeDetailComponent } from './detail/cooperative-detail.component';
import { CooperativeUpdateComponent } from './update/cooperative-update.component';
import { CooperativeDeleteDialogComponent } from './delete/cooperative-delete-dialog.component';
import { CooperativeRoutingModule } from './route/cooperative-routing.module';

import { QRCodeModule } from 'angular2-qrcode';

@NgModule({
  imports: [SharedModule, QRCodeModule, CooperativeRoutingModule],
  declarations: [CooperativeComponent, CooperativeDetailComponent, CooperativeUpdateComponent, CooperativeDeleteDialogComponent],
  entryComponents: [CooperativeDeleteDialogComponent],
})
export class CooperativeModule {}
