import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { InventorySharedLibsModule, InventorySharedCommonModule } from './';

@NgModule({
  imports: [InventorySharedLibsModule, InventorySharedCommonModule],
  exports: [InventorySharedCommonModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class InventorySharedModule {
  static forRoot() {
    return {
      ngModule: InventorySharedModule
    };
  }
}
