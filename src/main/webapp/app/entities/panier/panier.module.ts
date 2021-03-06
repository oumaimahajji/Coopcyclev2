import { NgModule } from '@angular/core';

import { SharedModule } from 'app/shared/shared.module';
import { PanierComponent } from './list/panier.component';
import { PanierDetailComponent } from './detail/panier-detail.component';
import { PanierUpdateComponent } from './update/panier-update.component';
import { PanierDeleteDialogComponent } from './delete/panier-delete-dialog.component';
import { PanierRoutingModule } from './route/panier-routing.module';

import { QRCodeModule } from 'angular2-qrcode';

@NgModule({
  imports: [SharedModule, QRCodeModule, PanierRoutingModule],
  declarations: [PanierComponent, PanierDetailComponent, PanierUpdateComponent, PanierDeleteDialogComponent],
  entryComponents: [PanierDeleteDialogComponent],
})
export class PanierModule {}
