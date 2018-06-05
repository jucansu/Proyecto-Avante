import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreacionPublicacionComponent } from './creacion-publicacion.component';

describe('CreacionPublicacionComponent', () => {
  let component: CreacionPublicacionComponent;
  let fixture: ComponentFixture<CreacionPublicacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreacionPublicacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreacionPublicacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
