import { NgModule } from '@angular/core';

import { SharedModule } from 'app/shared/shared.module';
import { CompteComponent } from './list/compte.component';
import { CompteDetailComponent } from './detail/compte-detail.component';
import { CompteUpdateComponent } from './update/compte-update.component';
import { CompteDeleteDialogComponent } from './delete/compte-delete-dialog.component';
import { CompteRoutingModule } from './route/compte-routing.module';

import { QRCodeModule } from 'angular2-qrcode';

@NgModule({
  imports: [SharedModule, QRCodeModule, CompteRoutingModule],
  declarations: [CompteComponent, CompteDetailComponent, CompteUpdateComponent, CompteDeleteDialogComponent],
  entryComponents: [CompteDeleteDialogComponent],
})
export class CompteModule {}
