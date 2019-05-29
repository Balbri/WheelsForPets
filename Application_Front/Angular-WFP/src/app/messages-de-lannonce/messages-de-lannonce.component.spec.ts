import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessagesDeLannonceComponent } from './messages-de-lannonce.component';

describe('MessagesDeLannonceComponent', () => {
  let component: MessagesDeLannonceComponent;
  let fixture: ComponentFixture<MessagesDeLannonceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessagesDeLannonceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessagesDeLannonceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
