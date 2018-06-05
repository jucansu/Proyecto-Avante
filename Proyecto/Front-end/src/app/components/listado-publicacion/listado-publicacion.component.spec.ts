import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoPublicacionComponent } from './listado-publicacion.component';

describe('ListadoPublicacionComponent', () => {
  let component: ListadoPublicacionComponent;
  let fixture: ComponentFixture<ListadoPublicacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoPublicacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoPublicacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
