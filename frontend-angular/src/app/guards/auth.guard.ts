import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  CanActivateFn, GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot
} from '@angular/router';
import {AuthService} from "../services/auth.service";
import {Injectable} from "@angular/core";


@Injectable()  // c'est pour dire que ce guard c'est un  service aussi
export class AuthGuard {
// alors pour ce service va etre fonctionner on va le declarrer dans le app.module.ts dans la partie providers
  constructor(private authService: AuthService,
              private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    if (this.authService.isAuthenticated) {
      return true;
    }else {
      this.router.navigateByUrl('login');
      return false;
    }
  }


}
