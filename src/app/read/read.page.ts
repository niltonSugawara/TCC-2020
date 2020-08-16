import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-read',
  templateUrl: './read.page.html',
  styleUrls: ['./read.page.scss'],
})
export class ReadPage implements OnInit {
    constructor(private navCtrl: NavController) { }

    ngOnInit() {
    }

    showPageHome() {
      this.navCtrl.navigateForward('home');

    }

}
