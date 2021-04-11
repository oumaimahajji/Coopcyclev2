import { NgModule } from '@angular/core';

import { SharedModule } from 'app/shared/shared.module';
import { ProduitComponent } from './list/produit.component';
import { ProduitDetailComponent } from './detail/produit-detail.component';
import { ProduitUpdateComponent } from './update/produit-update.component';
import { ProduitDeleteDialogComponent } from './delete/produit-delete-dialog.component';
import { ProduitRoutingModule } from './route/produit-routing.module';

import { QRCodeModule } from 'angular2-qrcode';

@NgModule({
  imports: [SharedModule, QRCodeModule, ProduitRoutingModule],
  declarations: [ProduitComponent, ProduitDetailComponent, ProduitUpdateComponent, ProduitDeleteDialogComponent],
  entryComponents: [ProduitDeleteDialogComponent],
})
export class ProduitModule {}
