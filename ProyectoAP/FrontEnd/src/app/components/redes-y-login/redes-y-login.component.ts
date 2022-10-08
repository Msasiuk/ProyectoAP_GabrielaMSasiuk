import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-redes-y-login',
  templateUrl: './redes-y-login.component.html',
  styleUrls: ['./redes-y-login.component.css']
})
export class RedesYLoginComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    this.router.navigate(['/login'])
  }

}
