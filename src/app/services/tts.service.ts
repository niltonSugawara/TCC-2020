import { TextToSpeech } from '@ionic-native/text-to-speech/ngx';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TtsService {

  constructor(private tTS: TextToSpeech) { }

  speeches(textTest: string) {
    this.tTS.speak({
      text: textTest,
      locale: 'en-US',
      rate: 1
   }).then(() => console.log('Function on'))
      .catch((resp: any) => console.error('Error tts ' + resp));
  }
}
