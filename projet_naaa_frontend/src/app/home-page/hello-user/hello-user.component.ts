import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/AuthService';

@Component({
  selector: 'app-hello-user',
  templateUrl: './hello-user.component.html',
  styleUrls: ['./hello-user.component.scss']
})
export class HelloUserComponent implements OnInit {
  user: any = undefined;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!);
    }
  }
}
