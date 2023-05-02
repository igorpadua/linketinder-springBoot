import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user.model";
import {Router} from "@angular/router";

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

  constructor(private router: Router) {}

  ngOnInit(): void {
  }

  login(): void {
    this.router.navigate(['/like-vaga']);
  }
}
