import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SpeakPage } from './speak.page';

const routes: Routes = [
  {
    path: '',
    component: SpeakPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SpeakPageRoutingModule {}
