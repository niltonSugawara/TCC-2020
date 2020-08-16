import { UtilService } from './../services/util.service';
import { ApiBdService } from './../services/api-bd.service';
import { Component, OnInit } from '@angular/core';
import { NavController, AlertController, ActionSheetController, LoadingController } from '@ionic/angular';
import { async } from '@angular/core/testing';
import { TtsService } from '../services/tts.service';

@Component({
  selector: 'app-write',
  templateUrl: './write.page.html',
  styleUrls: ['./write.page.scss'],
})
export class WritePage implements OnInit {
  [x: string]: any;
  tasks: any[] = [];

  ngOnInit() {
  }
  constructor(private navCtrl: NavController,
              private alertCtrl: AlertController,
              private utilService: UtilService,
              private actionSheetCtrl: ActionSheetController,
              private apiBdService: ApiBdService,
              private loadingCtrl: LoadingController,
              private ttsCtrl: TtsService) {

    this.loadTask();
    /* let taskJson: string;
    taskJson = localStorage.getItem('taskDb');
    if (taskJson != null) {
      this.tasks = JSON.parse(taskJson);
    }*/
  }

  talkSpeech(talkTest: string) {
    this.ttsCtrl.speeches(talkTest);

  }

  async loadTask() {
    const loading = await this.loadingCtrl.create({message: 'Listing Task...'});
    loading.present();
    this.apiBdService.list()
      .then(async (response: string[]) => {
        /*console.table(response);*/
        this.tasks = response;
        loading.dismiss();
      })
      .catch(async (messageError) => {
        this.utilService.showToast('Operation failed!');
        });
  }

  async showAdd() {
    const alert = await this.alertCtrl.create({
      header: 'Should be include new Class?',
      inputs: [
        {
          name: 'newTask',
          type: 'text',
          placeholder: 'Add new class'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'primary',
          handler: () => {
            console.log('clicked cancel');
          }
        },
        {
          text: 'Ok',
          handler: (form) => {
            console.log(form.newTask);
            this.add(form.newTask);
          }
        }
      ]
    });
    await alert.present();
  }

  async add(newTask: string) {
    if (newTask.trim().length < 1) {
      this.utilService.showToast('Tell us what you want to do');
      return;
    }

    const task = { name: newTask, done: false };

    /*this.tasks.push(task);
      this.updateLocalStorage();*/

    this.utilService.showLoading();

    this.apiBdService.add(task.name)
      .then(async (messageResponse) => {
        this.utilService.hideLoading();
        this.utilService.showToast('Operation performed successfully!');
        this.loadTask();
      })
      .catch(async (messageError) => {
        this.utilService.hideLoading();
        this.utilService.showToast('Operation failed!');
      });
  }

  /*updateLocalStorage() {
    localStorage.setItem('taskDb', JSON.stringify(this.tasks));
  }*/

  async openActions(task: any) {
    const actionSheet = await this.actionSheetCtrl.create({
      header: 'What do you want to do now?',
      buttons: [{
        text: task.done ? 'Unchecked' : 'Checked',
        icon: task.done ? 'radio-button-off' : 'checkMark-circle',
        handler: () => {
          task.done = !task.done;
          this.utilService.showLoading();
          this.apiBdService.update(task)
            .then(async (response) => {
              this.utilService.hideLoading();
              this.utilService.showToast('Operation performed successfully!');
            })
            .catch(async (messageError) => {
              this.utilService.hideLoading();
              this.utilService.showToast('Operation failed!');
            });
          /*this.updateLocalStorage();*/
        }
      }
        ,
      {
        text: 'Cancel',
        icon: 'close',
        role: 'cancel',
        handler: () => {
          console.log('Cancel clicked');
        }
      }]
    });
    await actionSheet.present();
  }

  async delete(task: any) {
    /*this.tasks = this.tasks.filter(taskArray => task !== taskArray);
    this.updateLocalStorage();*/
    this.utilService.showLoading();
    this.apiBdService.delete(task.id)
    .then(async (response) => {
      this.utilService.hideLoading();
      this.utilService.showToast('Operation performed successfully!');
      this.loadTask();
    })
    .catch(async (messageError) => {
      this.utilService.hideLoading();
      this.utilService.showToast('Operation failed!');
    });
  }

  showPageHome() {
    this.navCtrl.navigateForward('home');
  }
}
