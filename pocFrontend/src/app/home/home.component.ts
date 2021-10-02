import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  combination: number=0;
  result: number=0;

  constructor(private homeService: HomeService) { }

  ngOnInit(): void {
   
  }

  onCombinationClick(){
    this.homeService.getParantesisCombination(this.combination).subscribe((data)=>{
      this.result=data.combination;
    })  
  }

}
