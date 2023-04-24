import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subscribe',
  templateUrl: './subscribe.component.html',
  styleUrls: ['./subscribe.component.scss']
})
export class SubscribeComponent implements OnInit {
  isChecked = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onCheckboxChange() {
    this.isChecked = !this.isChecked;
  }
}
