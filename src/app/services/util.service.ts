import { ToastController, LoadingController } from '@ionic/angular';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class UtilService {

  public loading: HTMLIonLoadingElement;

  constructor(private toastCtrl: ToastController,
              private loadingCtrl: LoadingController) { }

  async showToast(message: string, duration: number= 2000) {
    const toast = await this.toastCtrl.create({
      message: message,
      duration: duration,
      cssClass: 'animated bounceInLeft',
      color: 'secondary',
      position: 'middle'
    });
    toast.present();
  }

  async showLoading(message: string = 'Loading...') {
    const loading = await this.loadingCtrl.create({message: message});
    this.loading = loading;

    this.loading.present();
  }

  hideLoading() {
    console.log(this.loading);

    if (this.loading != undefined && this.loading != null){
      this.loading.dismiss();
    }
  }
}
