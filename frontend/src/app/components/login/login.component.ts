import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User= {
    email: '',
    senha: ''
  }

  constructor() {}

  ngOnInit(): void {
  }

  login(): void {
    console.log(this.user)
  }
}
