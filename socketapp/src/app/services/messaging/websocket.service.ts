import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJs from 'sockjs-client';

import {Message} from 'stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  private stompClient;

  constructor() { }

  connect(): void {
    const ws = new SockJs('http://localhost:8080/gs-guide-websocket');
    this.stompClient = Stomp.over(ws);
    const _this = this;
    this.stompClient.connect({}, function(frame) {

      console.log('Connected\n' + frame);
    });
  }

  consume(): string {
    let response = '';
    this.stompClient.subscribe('/topic/queuedMessage', function(message) {
      console.log(message.body);
      response = message;
    });
    this.stompClient.unsubscribe();

    return response;
  }
}
