import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePublicacionComponent } from './delete-publicacion.component';

describe('DeletePublicacionComponent', () => {
  let component: DeletePublicacionComponent;
  let fixture: ComponentFixture<DeletePublicacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletePublicacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletePublicacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
