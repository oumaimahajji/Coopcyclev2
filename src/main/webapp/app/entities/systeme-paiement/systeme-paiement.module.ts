import { NgModule } from '@angular/core';

import { SharedModule } from 'app/shared/shared.module';
import { SystemePaiementComponent } from './list/systeme-paiement.component';
import { SystemePaiementDetailComponent } from './detail/systeme-paiement-detail.component';
import { SystemePaiementUpdateComponent } from './update/systeme-paiement-update.component';
import { SystemePaiementDeleteDialogComponent } from './delete/systeme-paiement-delete-dialog.component';
import { SystemePaiementRoutingModule } from './route/systeme-paiement-routing.module';

import { QRCodeModule } from 'angular2-qrcode';

@NgModule({
  imports: [SharedModule, QRCodeModule, SystemePaiementRoutingModule],
  declarations: [
    SystemePaiementComponent,
    SystemePaiementDetailComponent,
    SystemePaiementUpdateComponent,
    SystemePaiementDeleteDialogComponent,
  ],
  entryComponents: [SystemePaiementDeleteDialogComponent],
})
export class SystemePaiementModule {}
