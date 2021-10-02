import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ParantesisCombination } from '../models/parantesis-combination';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private REST_API_SERVER = "http://localhost:8080/AkinPocRest/rest/calculate/";

  constructor(private httpClient: HttpClient) { }

  public getParantesisCombination(count: number){
    return this.httpClient.get<ParantesisCombination>(this.REST_API_SERVER + count);
  }
}
