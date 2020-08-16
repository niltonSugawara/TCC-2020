import { async } from '@angular/core/testing';
import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  constructor(private navCtrl: NavController) {}

  ngOnInit() {
  }

  showPageWrite() {
    this.navCtrl.navigateForward('write');
  }

  showPageRead() {
    this.navCtrl.navigateForward('read');
  }

  showPageListen() {
    this.navCtrl.navigateForward('listen');
  }

  showPageSpeak() {
    this.navCtrl.navigateForward('speak');
  }
}
